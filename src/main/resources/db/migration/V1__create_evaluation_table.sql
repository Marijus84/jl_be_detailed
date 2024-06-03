CREATE TABLE evaluation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    timestamp TIMESTAMP NOT NULL,
    current_state_ids TEXT,
    crisis_test_result int
);