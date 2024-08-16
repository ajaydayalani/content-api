CREATE TABLE IF NOT EXISTS Content (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    `desc` TEXT,
    status VARCHAR(255) NOT NULL,
    content_type VARCHAR(255) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP ,
    url VARCHAR(255)
);

INSERT INTO Content(title, `desc`, status, content_type, date_created, date_updated, url)
VALUES('My First Video', 'SpringBoot Collab', 'IDEA', 'VIDEO', CURRENT_TIMESTAMP, NULL, 'https://test');
