package com.coders.endupdate.content.screen.custom;

import com.coders.endupdate.content.Util.ModTags;
import com.coders.endupdate.content.block.ModBlocks;
import com.coders.endupdate.content.block.blockentity.PedestalBlockEntity;
import com.coders.endupdate.content.screen.ModMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;

public class PedestalMenu extends AbstractContainerMenu {
    public final PedestalBlockEntity blockEntity;
    private final Level level;

    public PedestalMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public PedestalMenu(int containerId, Inventory inv, BlockEntity blockEntity) {
        super(ModMenuTypes.PEDESTAL_MENU.get(), containerId);
        this.blockEntity = ((PedestalBlockEntity) blockEntity);
        this.level = inv.player.level();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 0, 80, 35));
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 1;  // must be the number of slots you have!
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {

        if(blockEntity.getBlockState().is(ModBlocks.ENDSTONE_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.ENDSTONE_BRICKS_PEDESTAL.get());
        }

        if(blockEntity.getBlockState().is(ModBlocks.BLACKSTONE_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.BLACKSTONE_BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.MOSSY_STONE_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.MOSSY_STONE_BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.MUD_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.MUD_BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.NETHER_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.NETHER_BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.RED_NETHER_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.RED_NETHER_BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.PRISMARINE_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.PRISMARINE_BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.QUARTZ_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.QUARTZ_BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.RESIN_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.RESIN_BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.STONE_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.STONE_BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.TUFF_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.TUFF_BRICKS_PEDESTAL.get());
        }
        if(blockEntity.getBlockState().is(ModBlocks.DEEPSLATE_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.DEEPSLATE_BRICKS_PEDESTAL.get());
        }

        if(blockEntity.getBlockState().is(ModBlocks.MALACHITE_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.MALACHITE_BRICKS_PEDESTAL.get());
        }

        if(blockEntity.getBlockState().is(ModBlocks.SLUDGE_BRICKS_PEDESTAL)) {
            return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                    player, ModBlocks.SLUDGE_BRICKS_PEDESTAL.get());
        }


        return false;
    }



    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}