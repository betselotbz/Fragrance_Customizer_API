package com.example.fragrance_customizer_api.seed;

import com.example.fragrance_customizer_api.model.*;
import com.example.fragrance_customizer_api.repository.*;
import com.example.fragrance_customizer_api.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final PerfumeRepository perfumeRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public SeedData(@Lazy PasswordEncoder passwordEncoder, UserRepository userRepository, PerfumeRepository perfumeRepository, IngredientRepository ingredientRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.perfumeRepository = perfumeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("bethel");
        user.setEmailAddress("bethel@ga.com");
        user.setPassword(passwordEncoder.encode("bethel123"));
        userRepository.save(user);

        List<Ingredient> ingredients = List.of(
                new Ingredient(null, "Basil", "basil.jpg"),
                new Ingredient(null, "Lavender", "lavender.jpg"),
                new Ingredient(null, "Citrus", "citrus.jpg"),
                new Ingredient(null, "Vanilla", "vanilla.jpg"),
                new Ingredient(null, "Sandalwood", "sandalwood.jpg"),
                new Ingredient(null, "Peppermint", "peppermint.jpg"),
                new Ingredient(null, "Eucalyptus", "eucalyptus.jpg"),
                new Ingredient(null, "Jasmine", "jasmine.jpg"),
                new Ingredient(null, "Rose", "rose.jpg"),
                new Ingredient(null, "Cedarwood", "cedarwood.jpg"),
                new Ingredient(null, "Patchouli", "patchouli.jpg"),
                new Ingredient(null, "Ylang-Ylang", "ylang-ylang.jpg"),
                new Ingredient(null, "Lemon", "lemon.jpg"),
                new Ingredient(null, "Ginger", "ginger.jpg"),
                new Ingredient(null, "Chamomile", "chamomile.jpg"),
                new Ingredient(null, "Mint", "mint.jpg"),
                new Ingredient(null, "Amber", "amber.jpg"),
                new Ingredient(null, "Frankincense", "frankincense.jpg"),
                new Ingredient(null, "Myrrh", "myrrh.jpg"),
                new Ingredient(null, "Lavender", "lavender.jpg"),
                new Ingredient(null, "Orange", "orange.jpg")

                // ... add other ingredients
        );
        ingredientRepository.saveAll(ingredients);

        List<Perfume> perfumes = List.of(
                new Perfume(null, "Chanel No. 5", "Floral", "Classic floral fragrance with notes of jasmine and rose.", "chanel_no5.jpg"),
                new Perfume(null, "Dior J'adore", "Floral", "Elegant floral fragrance with notes of ylang-ylang and damask rose.", "dior_jadore.jpg"),
                new Perfume(null, "Coco Chanel Mademoiselle", "Floral-Oriental", "Chic and modern fragrance with notes of orange, rose, and patchouli.", "coco_mademoiselle.jpg"),
                new Perfume(null, "Tom Ford Black Orchid", "Oriental", "Luxurious and sensual fragrance with notes of black truffle, orchid, and vanilla.", "tom_ford_black_orchid.jpg"),
                new Perfume(null, "Chloe Nomade", "Chypre", "A fresh and woody fragrance with notes of oak moss, mirabelle plum, and freesia.", "chloe_nomade.jpg"),
                new Perfume(null, "Gucci Bloom", "Floral", "Captivating floral scent with notes of tuberose, jasmine, and Rangoon creeper.", "gucci_bloom.jpg"),
                new Perfume(null, "Marc Jacobs Daisy", "Floral-Fruity", "Playful and youthful fragrance with notes of strawberry, violet, and jasmine.", "marc_jacobs_daisy.jpg"),
                new Perfume(null, "Yves Saint Laurent Black Opium", "Oriental", "Bold and seductive fragrance with notes of coffee, vanilla, and white flowers.", "ysl_black_opium.jpg"),
                new Perfume(null, "Creed Aventus", "Woody", "Iconic and masculine fragrance with notes of pineapple, birch, and ambergris.", "creed_aventus.jpg"),
                new Perfume(null, "Jo Malone London Wood Sage & Sea Salt", "Woody-Aromatic", "Refreshing and earthy fragrance with notes of sea salt, sage, and ambrette seeds.", "jo_malone_wood_sage_sea_salt.jpg"),
                new Perfume(null, "Prada Candy", "Oriental-Vanilla", "Sweet and indulgent fragrance with notes of caramel, musk, and vanilla.", "prada_candy.jpg"),
                new Perfume(null, "Versace Bright Crystal", "Floral-Fruity", "Vibrant and fresh fragrance with notes of pomegranate, peony, and magnolia.", "versace_bright_crystal.jpg"),
                new Perfume(null, "Calvin Klein Eternity", "Floral", "Timeless floral fragrance with notes of freesia, mandarin, and sandalwood.", "ck_eternity.jpg"),
                new Perfume(null, "Bvlgari Omnia Crystalline", "Floral-Woody", "Elegant and luminous fragrance with notes of bamboo, lotus flower, and balsa wood.", "bvlgari_omnia_crystalline.jpg"),
                new Perfume(null, "Ralph Lauren Romance", "Floral", "Romantic and feminine fragrance with notes of rose, chamomile, and ginger.", "ralph_lauren_romance.jpg"),
                new Perfume(null, "Giorgio Armani Si", "Chypre", "Modern and sophisticated fragrance with notes of blackcurrant, vanilla, and musk.", "armani_si.jpg"),
                new Perfume(null, "Tommy Hilfiger Tommy Girl", "Floral-Fruity", "Youthful and energetic fragrance with notes of apple blossom, camellia, and sandalwood.", "tommy_girl.jpg"),
                new Perfume(null, "Dolce & Gabbana Light Blue", "Citrus", "Refreshing and iconic fragrance with notes of Sicilian lemon, apple, and bamboo.", "dg_light_blue.jpg"),
                new Perfume(null, "Issey Miyake L'Eau d'Issey", "Floral-Aquatic", "Timeless and aquatic fragrance with notes of lotus, freesia, and cyclamen.", "issey_miyake_leau_dissey.jpg"),
                new Perfume(null, "Kenzo Flower", "Floral", "Unique and powdery fragrance with notes of violet, vanilla, and rose.", "kenzo_flower.jpg")
        );

        perfumeRepository.saveAll(perfumes);


    }
}


