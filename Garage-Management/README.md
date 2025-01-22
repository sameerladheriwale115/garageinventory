# Inventory Management System Customization

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
   - [Customized User Interface](#1-customized-user-interface)
   - ["About" Page Addition](#2-about-page-addition)
   - [Sample Inventory Integration](#3-sample-inventory-integration)
   - ["Buy Now" Feature](#4-buy-now-feature)
   - [Inventory Limits (Max & Min)](#5-inventory-limits-max--min)
   - [Validation Enhancements](#6-validation-enhancements)
   - [Unit Testing](#7-unit-testing)
   - [Code Cleanup](#8-code-cleanup)
3. [Getting Started](#getting-started)
4. [Repository Structure](#repository-structure)
5. [Customization Details](#customization-details)
   - [User Interface](#user-interface)
   - ["About" Page](#about-page)
   - [Sample Inventory](#sample-inventory)
   - ["Buy Now" Button](#buy-now-button)
   - [Inventory Limits](#inventory-limits)
   - [Validation](#validation)
   - [Unit Tests](#unit-tests)
6. [Screenshots](#screenshots)
7. [License](#license)
8. [Contact](#contact)

## Overview

This project involves the customization of a Spring-based inventory management application to meet the specific needs of a customer who sells products composed of multiple parts. The base application, provided with a Java backend and a generic HTML user interface, has been tailored to handle the unique requirements of the chosen customer, ensuring a user-friendly and efficient inventory management experience.

## Features

### 1. Customized User Interface
- **Enhancements**: The HTML user interface has been updated to reflect the customer’s brand, including the shop name, product names, and part names.
- **Design**: Additional design elements were introduced to enhance usability and align the interface with the customer's visual identity.

### 2. "About" Page Addition
- **Company Overview**: An "About" page has been added to the application, providing a detailed description of the customer's company.
- **Navigation**: Seamless navigation has been implemented to allow users to move easily between the "About" page and the main screen.

### 3. Sample Inventory Integration
- **Custom Inventory**: A sample inventory specific to the customer’s store has been created, comprising five products and five parts.
- **Data Integrity**: The inventory is added without overwriting existing data, ensuring the safe and secure management of inventory records.

### 4. "Buy Now" Feature
- **Functionality**: A "Buy Now" button has been added next to each product in the inventory list, enabling users to decrement product inventory by one with a single click.
- **Feedback**: The system provides real-time feedback, displaying messages indicating the success or failure of each purchase.

### 5. Inventory Limits (Max & Min)
- **Tracking**: The parts tracking system has been upgraded to include maximum and minimum inventory fields.
- **Enforcement**: The application enforces these limits, preventing inventory levels from falling outside the specified ranges.

### 6. Validation Enhancements
- **Error Handling**: Validation rules have been added to ensure inventory levels are within the set maximum and minimum bounds.
- **User Notifications**: Appropriate error messages are displayed to guide users in maintaining correct inventory levels.

### 7. Unit Testing
- **Robustness**: At least two unit tests have been added to verify the functionality of the maximum and minimum inventory fields, ensuring the reliability of the system.

### 8. Code Cleanup
- **Optimization**: Unused validator classes have been removed from the codebase, maintaining a clean and efficient code structure.

## Getting Started

To get started with the project, follow these steps:

1. **Clone the Repository**: 
   ```bash
   git clone https://github.com/Selvawen/SpringBoot-Inventory-Management.git

2. **Set Up the Development Environment**:
    Follow the instructions in the provided setup.md file to configure your development environment.

3. **Explore the Code:**:
    Refer to the README sections below for guidance on where to find and understand the code changes.

4. **Run the Application**:
 Use the included instructions in the user-guide.md to run and interact with the application.

 ## Repository Structure

- **/src/main/java**: Java source code for backend logic.
- **/src/main/resources/templates**: HTML files for the user interface.
- **/src/test/java**: Unit tests for validating application logic.
- **/README.md**: This file.
- **/setup.md**: Detailed instructions for setting up the development environment.
- **/user-guide.md**: User guide for interacting with the application.

## Customization Details

### User Interface
- **File**: `src/main/resources/templates/index.html`
- **Lines**: Updated shop name, product names, and part names on lines X to Y.

### "About" Page
- **File**: `src/main/resources/templates/about.html`
- **Lines**: Added company description and navigation links on lines X to Y.

### Sample Inventory
- **File**: `src/main/java/com/example/inventory/InventoryInitializer.java`
- **Lines**: Added sample inventory data on lines X to Y.

### "Buy Now" Button
- **File**: `src/main/resources/templates/product-list.html`
- **Lines**: Added "Buy Now" button next to product actions on lines X to Y.

### Inventory Limits
- **File**: `src/main/java/com/example/inventory/model/Part.java`
- **Lines**: Added max and min fields on lines X to Y.

### Validation
- **File**: `src/main/java/com/example/inventory/validation/InventoryValidator.java`
- **Lines**: Added validation logic on lines X to Y.

### Unit Tests
- **File**: `src/test/java/com/example/inventory/PartTest.java`
- **Lines**: Added unit tests on lines X to Y.

### Screenshots
![tech1](https://github.com/user-attachments/assets/2836297e-4713-406b-92c2-4a22433514f5)
![tech2](https://github.com/user-attachments/assets/2e05e689-97e3-4bde-9324-f325a5a7d704)
![tech3](https://github.com/user-attachments/assets/8857c04b-5868-491d-8c38-dca9202159c2)
![tech4](https://github.com/user-attachments/assets/309e05de-475e-4fd3-92c0-e89ba421b0af)

## License

MIT License

Copyright (c) 2024 Benjamin Anderson

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

