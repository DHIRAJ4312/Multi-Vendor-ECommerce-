INSERT INTO category (id, name, slug) VALUES
  (1,'Electronics','electronics'),
  (2,'Books','books'),
  (3,'Fashion','fashion')
ON DUPLICATE KEY UPDATE name=VALUES(name), slug=VALUES(slug);
