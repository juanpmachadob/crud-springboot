# Crud Springboot

Simple crud in java springboot with mysql database.

## Starting 🚀

### Pre-requirements 📋

* [Git](https://git-scm.com/)
* [Java](https://www.oracle.com/java/technologies/downloads/)
* [MySQL](https://www.mysql.com/)

### Installation 🔧

Local installation:

```bash
# Clone this repository
$ git clone https://github.com/juanpmachadob/crud-springboot.git

# Change directory to the project path
$ cd crud-springboot

# Open your favorite IDE and run the project (IntelliJ IDEA recommended)
```

Database table creation:
```
CREATE TABLE clients (
    `id` INT ZEROFILL NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) NOT NULL,
    `last_name` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `created_at` date NOT NULL,
PRIMARY KEY (`id`));
```

## Built with 🛠️

* [Java](https://www.java.com/)
* [Springboot](https://spring.io/projects/spring-boot)

---
⌨️ with ❤️ by [Juan Pablo Machado](https://github.com/juanpmachadob ) 😊 
