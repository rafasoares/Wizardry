package electroblob.wizardry.client.gui.handbook;

import electroblob.wizardry.Wizardry;
import electroblob.wizardry.client.DrawingUtils;
import electroblob.wizardry.registry.WizardrySounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

//@SideOnly(Side.CLIENT)
class GuiButtonTurnPage extends GuiButton {

	static final int WIDTH = 20;
	static final int HEIGHT = 12;

	enum Type {
		
		NEXT_PAGE(0, 196),
		PREVIOUS_PAGE(0, 208),
		NEXT_SECTION(0, 220),
		PREVIOUS_SECTION(0, 232),
		CONTENTS(0, 244);
		
		private final int u, v;
		
		Type(int u, int v){
			this.u = u;
			this.v = v;
		}
	}
	
	public final Type type;

	private static final ResourceLocation texture = new ResourceLocation(Wizardry.MODID, "textures/gui/handbook.png");

	public GuiButtonTurnPage(int id, int x, int y, Type type){
		super(id, x, y, WIDTH, HEIGHT, "");
		this.type = type;
	}
	
	@Override
	public void playPressSound(SoundHandler soundHandler){
		soundHandler.playSound(PositionedSoundRecord.getMasterRecord(WizardrySounds.MISC_PAGE_TURN, 1));
	}

	@Override
	public void drawButton(Minecraft minecraft, int mouseX, int mouseY, float partialTicks){
		
		if(this.visible){
			
			boolean flag = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			minecraft.getTextureManager().bindTexture(texture);

			DrawingUtils.drawTexturedRect(this.x, this.y, flag ? type.u + width : type.u, type.v, width, height, 512, 256);
		}
	}
}
