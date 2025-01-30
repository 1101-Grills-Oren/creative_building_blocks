package code.creative_building_blocks.item.custom;

import java.util.List;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import com.example.docs.component.ModComponents;

//::1
public class EndGateway extends Item {
	public EndGateway(Settings settings) {
		super(settings);
	}

	//::1

	@Override
	//::2
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
		ItemStack stack = user.getStackInHand(hand);

		// Don't do anything on the client
		if (world.isClient()) {
			return ActionResult.SUCCESS;
		}
    		//Get the server
    		CommandManager commandManager = World.getCommandManager();
    		// `player` can be anything that can issue commands (i.e. a `CommandSource`)
    		commandManager.execute(player, "execute at @s rotated as @s align @s eyes run function creative_building_blocks:place_end_gateway/raytrace");
		return ActionResult.SUCCESS;
	}

	//::2

	@Override
	//::3
	/*public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		if (stack.contains(ModComponents.CLICK_COUNT_COMPONENT)) {
			int count = stack.get(ModComponents.CLICK_COUNT_COMPONENT);
			tooltip.add(Text.translatable("item.fabric-docs-reference.counter.info", count).formatted(Formatting.GOLD));
		}
	}*/

	//::3

	//::1
}
//::1
