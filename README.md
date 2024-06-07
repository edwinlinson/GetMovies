# 🎬 Movie App

## Overview
Movie App is a web application that allows users to browse, search, and add movies to their favorites. The application is built using Spring Boot for the backend and Angular for the frontend. It uses an H2 database to store movie data.

## Features
- **🎥 Get Movies**: Retrieve the list of all movies.
- **🔍 Search Movies**: Search for movies by title.
- **➕ Add Movies**: Add new movies to the database.
- **⭐ Add to Favorites**: Add movies to a list of favorites, stored locally in the browser.

## Technologies Used
- **Backend**: Spring Boot
- **Frontend**: Angular
- **Database**: H2 (in-memory database)

## Endpoints
### 🎥 Movies
- **Get All Movies**
  - **Endpoint**: `/api/movies`
  - **Method**: `GET`
  - **Description**: Retrieves the list of all movies.
  
- **Search Movies**
  - **Endpoint**: `/api/movies/search`
  - **Method**: `GET`
  - **Query Parameter**: `title`
  - **Description**: Searches for movies by title.
  - **Example**: `/api/movies/search?title=Inception`
  
- **Add Movie**
  - **Endpoint**: `/api/movie`
  - **Method**: `POST`
  - **Description**: Adds a new movie to the database.
  - **Request Body**: JSON object containing movie details.
  - **Example**: 
    ```json
    {
      "title": "Inception",
      "director": "Christopher Nolan",
      "releaseYear": 2010
    }
    ```

## Frontend Functionality
- **⭐ Add to Favorites**
  - **Description**: Users can add movies to their favorites list. The favorites are stored in the browser's local storage.

## Getting Started

### Prerequisites
- ☕ Java 11 or higher
- 🟢 Node.js and npm
- ⚙️ Angular CLI
- 🐍 Maven

### Backend Setup
1. Clone the backend repository:
   ```bash
   git clone https://github.com/edwinlinson/GetMovies
   cd movie-app-backend
You can find **Front end source code at** https://github.com/edwinlinson/getMoviesFrontend
