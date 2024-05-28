# Currency Converter

## Overview

This project implements a simple currency converter application in Java. It allows users to convert amounts between different currencies using exchange rates fetched from an external API.

## Components

### `CurrencyConverter.java`

This class is responsible for handling the currency conversion process. It interacts with the user to input the base and target currencies along with the amount to convert. It utilizes the `ExchangeRateFetcher` class to fetch exchange rates from an external API.

### `ExchangeRateFetcher.java`

This class is responsible for fetching exchange rates from an external API (`https://v6.exchangerate-api.com`). It uses the OkHttpClient library to make HTTP requests and the Jackson library to parse JSON responses. Exchange rates are fetched based on the provided base currency.

## Requirements

- Java Development Kit (JDK) installed on your system.
- Internet connection to fetch exchange rates from the external API (`https://v6.exchangerate-api.com`).
- Dependency on OkHttpClient and Jackson libraries for making HTTP requests and parsing JSON responses respectively.

## Usage

1. Compile the Java files using a Java compiler.
2. Run the `CurrencyConverter` class.
3. Follow the prompts to enter the base and target currencies along with the amount to convert.
4. The converted amount will be displayed based on the fetched exchange rates.

## Note

Ensure that you have an active internet connection to fetch the latest exchange rates from the API (`https://v6.exchangerate-api.com`).
