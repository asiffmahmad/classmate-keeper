-- scheme details
-- these table we are using for storing the details.


CREATE TABLE IF NOT EXISTS student_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    address_1 VARCHAR(100),
    address_2 VARCHAR(100),
    phone_number_1 VARCHAR(20),
    phone_number_2 VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL
);



