-- Eliminar la clave foránea
ALTER TABLE usuarios DROP FOREIGN KEY usuarios_ibfk_1;

-- Eliminar la columna perfil_id
ALTER TABLE usuarios DROP COLUMN perfil_id;