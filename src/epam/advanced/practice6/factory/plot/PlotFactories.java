package epam.advanced.practice6.factory.plot;

import java.util.StringJoiner;

class PlotFactories {

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        return () -> new Plot() {
            @Override
            public String toString() {
                return String.format(
                        "%s is great. " +
                                "%s and %s love each other. " +
                                "%s interferes with their happiness but loses in the end."
                        , hero.name()
                        , hero.name()
                        , beloved.name()
                        , villain.name()
                );
            }
        };
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        return () -> new Plot() {
            @Override
            public String toString() {
                return String.format(
                        "%s feels a bit awkward and uncomfortable. But personal issues fades, when a big trouble comes - %s. %s stands up against it, but with no success at first.But putting self together and help of friends, including spectacular funny %s restore the spirit and %s overcomes the crisis and gains gratitude and respect"
                        , hero.name()
                        , epicCrisis.name()
                        , hero.name()
                        , funnyFriend.name()
                        , hero.name()
                );
            }
        };
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        return () -> new Plot() {
            @Override
            public String toString() {
                // prepare heroes list
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < heroes.length; i++) {
                    builder.append(" brave ").append(heroes[i].name());
                    if(i != heroes.length-1){
                        builder.append(",");
                    }
                }

                return String.format(
                        "%s threatens the world. But%s on guard. So, no way that intrigues of %s overcome the willpower of inflexible heroes"
                        , epicCrisis.name()
                        , builder.toString()
                        , villain.name()
                );
            }
        };
    }
}
