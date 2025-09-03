-- Create a custom database
CREATE DATABASE docker_app;

-- Connect to the new database
\c docker_app;

-- Create a table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(100) NOT NULL
);

-- Insert some sample data
INSERT INTO users (user_name, user_email) VALUES
('Ahmed Samy', 'serenitydiver@hotmail.com');