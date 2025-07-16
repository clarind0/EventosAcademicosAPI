CREATE TABLE palestrante (
                         id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         evento_id UUID,
                         FOREIGN KEY (evento_id) REFERENCES evento(id) ON DELETE CASCADE
);