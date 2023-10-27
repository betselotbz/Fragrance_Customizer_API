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
    private final CustomFragranceRepository customFragranceRepository;

    @Autowired
    public SeedData(@Lazy PasswordEncoder passwordEncoder, UserRepository userRepository, PerfumeRepository perfumeRepository, IngredientRepository ingredientRepository, CustomFragranceRepository customFragranceRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.perfumeRepository = perfumeRepository;
        this.ingredientRepository = ingredientRepository;
        this.customFragranceRepository = customFragranceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("bethel");
        user.setEmailAddress("bethel@ga.com");
        user.setPassword(passwordEncoder.encode("bethel123"));
        user.setType("admin");
        userRepository.save(user);

        List<Ingredient> ingredients = List.of(
                new Ingredient(null, "Rose", "https://www.arkanlabs.com/image/cache/catalog/2026911000028756452-500x500.jpg"),
                new Ingredient(null, "Jasmine", "https://shopme365.com/image/cache/catalog/koreancosmetics/apieu/apieumyhandyroll-onperfumejasmine10ml-400x350.jpg"),
                new Ingredient(null, "Basil", "https://shopme365.com/image/cache/catalog/koreancosmetics/apieu/apieumyhandyroll-onperfumebasil10ml-500x500.jpg"),
                new Ingredient(null, "Cashmere", "https://koreacosmeticsbn.com/cdn/shop/products/06bf1c72-dfb1-4017-be15-4b94a94888ce_5000x.webp?v=1667456544"),
                new Ingredient(null, "Bergamot", "https://cdn.experimentalperfumeclub.com/wp-content/uploads/2022/11/EPC-Bergamot-Incense-50ml-sq-new-400x400.jpg"),
                new Ingredient(null, "Amber", "https://cdn.experimentalperfumeclub.com/wp-content/uploads/2022/11/EPC-Amber-Iris-50ml-sq-new-400x400.jpg"),
                new Ingredient(null, "Peony", "https://koreacosmeticsbn.com/cdn/shop/products/peonyperfume_530x_2x_c6ca51e7-e5f3-4541-9a14-20c3deddffce_2000x.webp?v=1667456545"),
                new Ingredient(null, "Sandalwood", "https://cdn.experimentalperfumeclub.com/wp-content/uploads/2022/11/EPC-Sandalwood-Musk-50ml-sq-new.jpg"),
                new Ingredient(null, "Patchouli", "https://rootedearth.com/cdn/shop/products/il_fullxfull.1198345357_8yr6_900x.jpg?v=1550961532"),
                new Ingredient(null, "Vanilla", "https://cdn11.bigcommerce.com/s-jdd57/images/stencil/2048x2048/products/153/887/vanilla_fragrance_Oil__58437.1543524968.jpg?c=2"),
                new Ingredient(null, "Citrus", "https://veroniquegabai.com/cdn/shop/products/10ml-oranges_1400x.jpg?v=1665687527"),
                new Ingredient(null, "Grapefruit", "https://koreacosmeticsbn.com/cdn/shop/products/APIEU-Handy-Roll-On-Perfume-Grapefruit_2000x.jpg?v=1667456543"),
                new Ingredient(null, "Tonka Sesame", "https://cdn.experimentalperfumeclub.com/wp-content/uploads/2022/11/EPC-Tonka-Sesame-50ml-sq.jpg"),
                new Ingredient(null, "Plum", "https://koreacosmeticsbn.com/cdn/shop/products/plum-1_4d719abc87bb4025bbeb8c3f18e0ec38_2000x.jpg?v=1667456544"),
                new Ingredient(null, "Fig Neroli", "https://cdn.experimentalperfumeclub.com/wp-content/uploads/2022/11/EPC-Fig-Neroli-50ml-sq-new.jpg"),
                new Ingredient(null, "Cedarwood Absinth", "https://experimentalperfumeclub.com/wp-content/uploads/2022/11/Cedarwood-Absinth-50ml-LR.jpg")
//                new Ingredient(null, "Chamomile", "chamomile.jpg"),
//                new Ingredient(null, "Mint", "mint.jpg"),
//                new Ingredient(null, "Amber", "amber.jpg"),
//                new Ingredient(null, "Frankincense", "frankincense.jpg"),
//                new Ingredient(null, "Myrrh", "myrrh.jpg"),
//                new Ingredient(null, "Lavender", "lavender.jpg"),
//                new Ingredient(null, "Orange", "orange.jpg")

                // ... add other ingredients
        );
        ingredientRepository.saveAll(ingredients);

        List<Perfume> perfumes = List.of(

                new Perfume(null, "DIOR - J'adore", "Floral", "Elegant floral fragrance with notes of ylang-ylang and damask rose.", "https://www.sephora.com/productimages/sku/s1710060-main-zoom.jpg?imwidth=612",110.5),
                new Perfume(null, "GUCCI - Bloom", "Floral", "Captivating floral scent with notes of tuberose, jasmine, and Rangoon creeper.", "https://www.sephora.com/productimages/sku/s2541548-main-zoom.jpg?imwidth=612",500.0),
                new Perfume(null, "CALVIN KLEIN - Eternity", "Floral", "Timeless floral fragrance with notes of freesia, mandarin, and sandalwood.", "https://media.kohlsimg.com/is/image/kohls/5084368?wid=805&hei=805&op_sharpen=1",45.55),
                new Perfume(null, "GIORGIO ARMANI - My Way", "Floral", "a modern floral fragrance with notes of bergamot, orange blossom, tuberose, and vanilla", "https://www.sephora.com/productimages/sku/s2551091-main-zoom.jpg?imwidth=612",11.0),


                new Perfume(null, "TOM FORD - Black Orchid", "Oriental", "Luxurious and sensual fragrance with notes of black truffle, orchid, and vanilla.", "https://www.sephora.com/productimages/sku/s1007731-main-zoom.jpg?imwidth=612",67.99),
                new Perfume(null, "YVSL - Black Opium", "Oriental", "Bold and seductive fragrance with notes of coffee, vanilla, and white flowers.", "https://www.sephora.com/productimages/sku/s1698182-main-zoom.jpg?imwidth=612",56.77),
                new Perfume(null, "JIMMY CHOO - I Want Choo", "Oriental", "rich and warm notes, sometimes with a combination of floral, fruity, and spicy elements.", "https://www.sephora.com/productimages/sku/s2636215-main-zoom.jpg?imwidth=612",78.0),


                new Perfume(null, "CREED AVENTUS", "Woody", "Iconic and masculine fragrance with notes of pineapple, birch, and ambergris.", "https://images.bloomingdalesassets.com/is/image/BLM/products/7/optimized/12524077_fpx.tif?op_sharpen=1&wid=700&fit=fit,1&$filtersm$&fmt=webp",99.99),
                new Perfume(null, "VERONIQUE GABAI - Ready for Rose", "Woody", "Woody fragrance with notes of pineapple, birch, and ambergris, creating an iconic and masculine scent.", "https://cdn.scentbird.com/product/rebrand/img-3261-1.jpg?w=288&bgcolor=f7efe9",76.00),
                new Perfume(null, "MICHAEL KORS - Sexy Amber", "Woody", "Warm and inviting woody fragrance featuring rich amber and sandalwood notes for a luxurious and elegant scent.", "https://cdn.scentbird.com/product/rebrand/87.jpg?w=288&bgcolor=f7efe9",29.99),
                new Perfume(null, "AMBER - Rag & Bone", "Woody", "Alluring fragrance characterized by its rich and warm amber notes, delivering a sophisticated and enticing olfactory experience.", "https://cdn.scentbird.com/product/rebrand/img-2238-1.jpg?w=519&bgcolor=fff",9.0),


                new Perfume(null, "GIORGIO ARMANI - Acqua di Gioia", "Aquatic Fragrances", "A fresh and aquatic scent with notes of mint, lemon, and jasmine, inspired by nature's elements.", "https://www.sephora.com/productimages/sku/s1284249-main-zoom.jpg?imwidth=612",12.0),
                new Perfume(null, "DAVIDOFF - Cool Water", "Aquatic", "Fresh and oceanic, often containing marine notes.", "https://pimages.parfumo.de/720/36_img-1325-davidoff-cool-water-woman_720.jpg",56.0),
                new Perfume(null, "DOLCE & GABBANA - Light Blue", "Aquatic", "Refreshing and iconic fragrance with notes of Sicilian lemon, apple, and bamboo.", "https://www.sephora.com/productimages/sku/s1942804-main-zoom.jpg?imwidth=612",78.8),
                new Perfume(null, "CHANCE - Chanel", "Aquatic", "A vibrant and lively fragrance, blending floral and fruity notes for a fresh and playful scent that embodies the spirit of spontaneity and elegance.", "https://www.sephora.com/productimages/sku/s1001098-main-zoom.jpg?imwidth=612",98.9),
                new Perfume(null, "GIORGIO ARMANI - Ocean di Gioia", "Aquatic", "A fresh and floral fragrance featuring notes of lemon, pear, violet leaf, peony, jasmine, cedar, and cashmere wood, creating a harmonious and refreshing scent.", "https://www.sephora.com/productimages/sku/s2319440-main-zoom.jpg?imwidth=612",56.0),

                new Perfume(null, "BURBERRY - Her", "Sweet", "Playful blend of green almond and sugared almonds, offering a modern and sophisticated fragrance", "https://cdn.scentbird.com/product/rebrand/3.jpg?w=519&bgcolor=fff",12.90),
                new Perfume(null, "SIGNORINA - Salvatore Ferragamo", "Sweet", "Charming fragrance that combines fruity and floral notes, creating a graceful and feminine scent with a touch of sophistication.", "https://cdn.scentbird.com/product/rebrand/584.jpg?w=519&bgcolor=fff",250.0),
                new Perfume(null, "PRADA - Candy Florale", "Sweet", "Blend of citrus, limoncello, peony, musk, benzoin, caramel, honey, and powdery notes, combining a delicate bouquet for a soft and feminine allure.", "https://cdn.scentbird.com/product/rebrand/630.jpg?w=288&bgcolor=f7efe9",120.0),
                new Perfume(null, "JUICY COUTURE - Viva La Juicy Noir", "Sweet", "A blend of wild berries, honeysuckle, jasmine, caramel, vanilla, and sandalwood, creating a rich and seductive scent that's both sweet and alluring", "https://cdn.scentbird.com/product/rebrand/274.jpg?w=288&bgcolor=f7efe9",85.99)

        );

        perfumeRepository.saveAll(perfumes);


        List<CustomFragrance> customFragrances = List.of(

                new CustomFragrance(null, "cr7")
        );

        customFragranceRepository.saveAll(customFragrances);


    }
}


