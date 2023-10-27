*Backend README.md**

# **Fragrance Customizer Backend**

## **NECTARED**

**Fragrance Customizer API**

## **Description**

Fragrance Customizer API serves as the backend for the Fragrance Customizer platform. It manages user authentication, provides access to the catalog of perfumes, allows users to customize their fragrances, and handles order processing. The backend ensures secure and efficient communication between the frontend and the database.
- **User Authentication Management:** Fragrance Customizer API takes care of user authentication, allowing individuals to register securely, log in, and access personalized features based on their roles and permissions.

- **Catalog Management:** The API provides comprehensive access to a diverse catalog of perfumes, offering users a wide array of choices to explore and select from.

- **Fragrance Customization:** Users can harness the API's capabilities to craft their own unique fragrances. The backend facilitates the selection of ingredients and oils, empowering users to express their creativity.

- **Order Processing:** Fragrance Customizer API takes charge of the entire order processing pipeline. From the moment users decide to purchase a product or customize their fragrance, to the finalization of the order, the backend ensures a smooth and efficient process.

- **Security and Efficiency:** Security is a top priority for Fragrance Customizer API. It employs robust measures to safeguard user data, ensuring the confidentiality and integrity of sensitive information. Additionally, the API is designed for optimal performance, ensuring responsiveness and efficiency.



## Development **Approach**


- **Agile Methodology:**
  Used a flexible approach that allowed quick adjustments when things changed.

- **User-Centric Design:**
  Prioritized user experience through interviews, feedback gathering, and iterative interface improvements.

- **Version Control:**
  Employed Git for version control, following best practices for collaboration and project history.

- **Code Reviews:**
  Conducted regular code reviews to maintain, reformat or analyze the bigger scope of th project.
  Making sure to use Dry and Kiss Principles.

- **Documentation:**
  Emphasized thorough documentation using Doc Strings for clarity on code, and project structure.

- **Testing Strategy:**
  Implemented a comprehensive testing strategy, including TDD principles.

- **Daily Stand-ups:**
  Daily goal-setting routine, defining progress objectives and project milestones with class team to ensure steady progress and alignment with project goals.

- **Feedback Loops:**
  Established continuous feedback loops with instructors, and my class team.


<img src="src/main/resources/Static/Approach.jpeg" alt="Approach Image" width="300"/>

## **User Stories**

### **As a Guest User:**

1. **View Perfume Catalog:**
    - I want to browse a catalog of available perfumes to see what options are available.

2. **Register for an Account:**
    - I want to register for an account so that I can personalize my fragrance choices.

### **As a Registered User:**

3. **Log In:**
    - I want to log in to my account to access personalized features.

4. **View Personalized Perfume Section:**
    - I want to be able to filter to view personalized section of perfumes based on my preferences.

5. **Add Perfume to Cart:**
    - I want to add perfumes to my cart for easy checkout.

6. **Access Custom Fragrance Section:**
    - I want to access a section where I can create a custom fragrance.

7. **View Ingredients for Custom Fragrance:**
    - I want to see a list of available ingredients for customizing my fragrance.

8. **Add Ingredients to Local Cart:**
    - I want to add ingredients to my local cart to customize my fragrance.

9. **Name and Save Customized Fragrance:**
    - I want to name and save my customized fragrance for future reference.

10. **Add Custom Fragrance to Main Cart:**

    - I want to add my customized fragrance to the main cart for purchase.

### **As an Admin User:**

11. **View List of Orders:**
- I want to view a list of all orders placed by registered users.

12. **Track Orders by User:**
- I want to track individual orders and see which user made each purchase.




1. **Repository URL**
   ```bash
   git clone [https://github.com/betselotbz/Fragrance_Customizer_API.git]

## Entity Relationship Diagram (ERD)
![ERD_ FRAGRANCE.png](src%2Fmain%2Fresources%2FStatic%2FERD_%20FRAGRANCE.png)
## State Diagram
![State.jpeg](src%2Fmain%2Fresources%2FStatic%2FState.jpeg)

## **API Endpoints**

### **Authentication:**

- **Register User:**
    - **Endpoint:** `POST /auth/users/register`
    - **Description:** Allows guests to register for a new account.

- **Login User:**
    - **Endpoint:** `POST /auth/users/login`
    - **Description:** Allows registered users to log in.

### **Perfumes:**

- **Get Perfume Catalog:**
    - **Endpoint:** `GET /api/perfumes`
    - **Endpoint:** `GET /api/perfumes/family/{family}`

### **Custom Fragrance:**

- **Get Ingredients for Custom Fragrance:**
    - **Endpoint:** `GET /api/custom-fragrance/ingredients`


- **Add Ingredient to Local Cart:**
    - **Endpoint:** `POST /api/custom-fragrance/cart`


- **Update Ingredient in Local Cart:**
    - **Endpoint:** `PUT /api/custom-fragrance/cart/:id`


- **Place Order for Custom Fragrance:**
    - **Endpoint:** `POST /api/custom-fragrance/order`


### **Admin:**

- **Get List of Orders:**
    - **Endpoint:** `GET /api/admin/orders`



## **Tools and Technologies**

- Spring Boot
- Java
- Postman
- Spring Boot Dependencies
- Testing Dependencies
- H2 Dependency
- JWT Dependencies
- OpenAPI Dependency

## **Citations**
    - https://mdbootstrap.com/docs/standard/extended/shopping-carts/
    - https://www.w3schools.com/
    - https://stackoverflow.com/
    - https://getbootstrap.com/docs/4.0/components/card/
    - https://chat.openai.com/chat
## **Acknowledgments**


- **Instructors and Mentors:**
    - I want to express my sincere appreciation to our instructors for their guidance, support, and valuable feedback throughout the development of this project. Their expertise has been instrumental in shaping the project's success.

- **Peers and Collaborators:**
    - Special thanks to my peers and collaborators who offered support, collaborated on problem-solving, and provided valuable insights. Working together made the development journey more enjoyable and productive.

These acknowledgments reflect the collaborative and supportive nature of the development process, and I am grateful to everyone who contributed in various ways.
<br>
### Betselot Bezabeh


<img src="src/main/resources/static/Betselot.jpg" height="100" alt="Picture of Gabrielle">

[<img src="src/main/resources/static/GithubIcon.png" height= "100" style="margin-bottom:-19px">](https://github.com/betselotbz)
[<img src="src/main/resources/static/LinkedIn.png" height="50px" style="margin-right:10px">](http://www.linkedin.com/in/betselot-bezabeh-94643420a)
