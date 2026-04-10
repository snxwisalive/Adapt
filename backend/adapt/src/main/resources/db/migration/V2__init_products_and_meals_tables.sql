CREATE TABLE products (
    id uuid PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    calories DOUBLE PRECISION NOT NULL,
    protein DOUBLE PRECISION NOT NULL,
    fat DOUBLE PRECISION NOT NULL,
    carbs DOUBLE PRECISION NOT NULL,
    source VARCHAR(255) NOT NULL,
    external_id VARCHAR(255),
    created_by uuid,
    CONSTRAINT fk_created_by FOREIGN KEY(created_by) REFERENCES users(id)
);

CREATE TABLE meals (
    id uuid PRIMARY KEY,
    user_id uuid NOT NULL,
    CONSTRAINT fk_user_id FOREIGN KEY(user_id) REFERENCES users(id),
    meal_type VARCHAR(255) NOT NULL,
    meal_date DATE NOT NULL
);

CREATE TABLE food (
    id uuid PRIMARY KEY,
    meal_id uuid NOT NULL,
    CONSTRAINT fk_meal FOREIGN KEY(meal_id) REFERENCES meals(id),
    product_id uuid NOT NULL,
    CONSTRAINT fk_product_details FOREIGN KEY(product_id) REFERENCES products(id),
    amount DOUBLE PRECISION NOT NULL
);