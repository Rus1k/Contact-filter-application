CREATE DATABASE contact;
CREATE USER homeWorkPart2 WITH password 'root';
GRANT ALL PRIVILEGES ON DATABASE contact to homeWorkPart2;
CREATE SEQUENCE auto_id_contacts;
CREATE TABLE public.contact (
  id  BIGINT PRIMARY KEY NOT NULL DEFAULT nextval('auto_id_contacts'),
  name CHARACTER VARYING(255)
);