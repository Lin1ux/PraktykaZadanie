DROP TABLE IF EXISTS nbp_request;

CREATE TABLE nbp.nbp_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(255),
    currency VARCHAR(255),
    request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    value INT
);

INSERT INTO nbp.nbp_requests (nickname, currency, value)
VALUES ('JanKowalski', 'EUR', 100);

INSERT INTO nbp.nbp_requests (nickname, currency, value)
VALUES ('JanKowalski', 'PLN', 1);