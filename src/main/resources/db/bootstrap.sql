-- Password generated as echo "md5`md5 -qs secretemployees_owner`"
CREATE ROLE employees_owner LOGIN
    ENCRYPTED PASSWORD 'md52c5268ba880a0582388bb59dd9479f25'
    NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

-- Password generated as echo "md5`md5 -qs secretemployees_app`"
CREATE ROLE employees_app LOGIN
    ENCRYPTED PASSWORD 'md519efe5d748bda9b448211f94ed575153'
    NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;

-- Create database
CREATE DATABASE employees_db
    WITH OWNER = employees_owner
        ENCODING = 'UTF8';
