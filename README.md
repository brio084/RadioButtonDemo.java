## Project Description

Radio Button Demo is a Java Swing application that demonstrates the use of **JRadioButton**, **ButtonGroup**, **JLabel**, **ImageIcon**, and **JOptionPane**.

The application allows users to select one of five pets using radio buttons. When a pet is selected, its corresponding image is displayed and a message dialog shows the selected pet.

---

## Features

- Five radio buttons:
  - Bird
  - Cat
  - Dog
  - Rabbit
  - Pig
- Only one radio button can be selected at a time using `ButtonGroup`.
- Displays the selected pet image (loaded from `images/` or classpath).
- Shows a confirmation message using `JOptionPane`.
- Simple and user-friendly graphical interface.

---

## Technologies Used

- Java
- Java Swing
- Apache NetBeans IDE (optional)

---

## Project Structure

```
RadioButtonDemo
│
├── RadioButton.java           (main Java source - single class GUI)
├── images/                    (image assets used by the app)
│   ├── bird.png
│   ├── cat.png
│   ├── dog.png
│   ├── rabbit.png
│   └── pig.png
│
├── README.md
├── Readme.docx
├── OOP2 JAVA CODE ASSIGNMENT.docx
├── Screenshot.jpeg
├── Screenshot(1).jpeg
└── Screenshot(2).jpeg
```

---

## How to Run

1. Ensure you have a Java JDK installed (javac and java on PATH).
2. The application looks for images in the following order:
   - classpath resource `/images/<pet>.png` (when running from a JAR or IDE resources)
   - `images/<pet>.png` or `images/<pet>.jpg` in the working directory
   - `<pet>.png` or `<pet>.jpg` in the working directory (backwards compatible)
   - if none are found a generated placeholder image will be shown

3. The repository includes small placeholder PNGs in `images/`. To run from the command line:

```
javac RadioButton.java
java RadioButton
```

4. If you open the project in NetBeans, add `RadioButton.java` to a simple Java application project and add the `images/`folder to the project resources (or copy the images into the working directory), then run the project.

---

## Expected Output

When a radio button is selected:

- The corresponding pet image is displayed.
- A message dialog appears showing the selected pet.

Example:

```
You selected: Bird
```

---

## Author

**Konyanga Brian Pchumba**

Software Engineering Student

Zetech University
