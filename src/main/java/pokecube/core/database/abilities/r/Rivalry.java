package pokecube.core.database.abilities.r;

import pokecube.core.database.abilities.Ability;
import pokecube.core.interfaces.IPokemob;
import pokecube.core.interfaces.capabilities.CapabilityPokemob;
import pokecube.core.interfaces.pokemob.moves.MovePacket;

public class Rivalry extends Ability
{
    @Override
    public void onMoveUse(IPokemob mob, MovePacket move)
    {

        if (!move.pre) return;
        IPokemob target = CapabilityPokemob.getPokemobFor(move.attacked);
        if (mob == move.attacker && target!=null)
        {
            byte mobGender = mob.getSexe();
            byte targetGender = target.getSexe();
            if (mobGender == IPokemob.SEXLEGENDARY || targetGender == IPokemob.SEXLEGENDARY
                    || mobGender == IPokemob.NOSEXE || targetGender == IPokemob.NOSEXE) { return; }

            if (mobGender == targetGender)
            {
                move.PWR *= 1.25;
            }
            else
            {
                move.PWR *= 0.75;
            }
        }
    }
}
