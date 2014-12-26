package eu.teslacraft.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import eu.teslacraft.items.TileEntityWindmill;
import eu.teslacraft.renderer.tileentity.TileEntityRenderWindmill;

/**
 * Created by Lukin on 25.12.2014.
 */
public class ClientProxy extends CommonProxy {

    public void registerProxies(){
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmill.class, new TileEntityRenderWindmill());
    }

}
