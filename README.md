# Follow the steps below to set up and run the project locally.

### Step 1: Clone & Unzip the Repository

1. Download or clone the repository.
2. Unzip the archive if downloaded as a `.zip` file.

### Step 2: Generate Random Data

1. Open the `RandomDataGenerator` folder in **IntelliJ IDEA** using the **"Open Project"** option.
2. Run the `RandomDataGenerator.java` file.
3. This will generate mock random data for testing purposes.

### Step 3: Create the Database

Create a MySQL table using the following SQL:
1. 
```sql
CREATE TABLE data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    value VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    status ENUM('active', 'inactive') DEFAULT 'active',
    category VARCHAR(100)
);
```
2. Insert the Random Generated Data from the `.txt` file into the `data` table

### Step 4: Run the Main Project

1. Open the `Database_project` folder in **IntelliJ IDEA** using the **"Open Project"** option.
2. Don't forget to add SDK in the IDE to run the project [I used OpenJDK 21]
3. Locate and run the `Database_project.java` file to launch the main application.

---

## You're All Set!
