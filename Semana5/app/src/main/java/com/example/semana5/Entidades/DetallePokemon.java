package com.example.semana5.Entidades;

import com.google.gson.annotations.SerializedName;

public class DetallePokemon {
    public int id;
    public String name;
    public int height;
    public int weight;
    public Sprites sprites;

    public class Sprites {
        public String front_default;
        public String back_default;

        public Versions versions;

        public class Versions {
            @SerializedName("generation-v")
            public GenerationV generationV;

            public class GenerationV {
                @SerializedName("black-white")
                public BlackWhite blackWhite;

                public class BlackWhite {
                    public Animated animated;

                    public class Animated {
                        public String front_default;
                    }
                }
            }
        }
    }
}
