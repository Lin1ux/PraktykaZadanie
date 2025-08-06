DROP TABLE IF EXISTS nbp.nbp_requests;

CREATE TABLE nbp.nbp_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    currency VARCHAR(255),
    request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    value DECIMAL(10, 4)
);

INSERT INTO nbp.nbp_requests (nickname, currency, value)
VALUES ('JanKowalski', 'EUR', 100);

INSERT INTO nbp.nbp_requests (nickname, currency, value)
VALUES ('JanKowalski', 'PLN', 1);

SELECT * FROM nbp.nbp_requests;