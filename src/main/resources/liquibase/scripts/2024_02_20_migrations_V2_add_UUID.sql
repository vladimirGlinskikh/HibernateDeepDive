CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Добавляем временный столбец для хранения временных значений id
ALTER TABLE employee ADD COLUMN temp_id UUID;

-- Копируем значения из столбца id во временный столбец temp_id
UPDATE employee SET temp_id = uuid_generate_v4();

-- Удаляем столбец id
ALTER TABLE employee DROP COLUMN id;

-- Переименовываем временный столбец temp_id в id
ALTER TABLE employee RENAME COLUMN temp_id TO id;

-- Добавляем временный столбец для хранения временных значений id
ALTER TABLE product ADD COLUMN temp_id UUID;

-- Копируем значения из столбца id во временный столбец temp_id
UPDATE product SET temp_id = uuid_generate_v4();

-- Удаляем столбец id
ALTER TABLE product DROP COLUMN id;

-- Переименовываем временный столбец temp_id в id
ALTER TABLE product RENAME COLUMN temp_id TO id;
