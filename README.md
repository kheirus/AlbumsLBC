Albums LBC App
==================

![AlbumsLBC](/docs/demo/albumslbc_demo.gif)

This project is an Android application that displays a list of albums.

# Architecture

The **AlbumsLBC** app follows the
[official architecture guidance](https://developer.android.com/topic/architecture) 
and has been greatly inspired by [nowinandroid](https://github.com/android/nowinandroid)

# Module Responsibilities

## Feature Module:
Contains the Album feature. This module is responsible for the UI layer, where you will find the 
Screen and its Components. The ViewModel also belongs to this module since it's responsible for 
managing the UI state and data displayed on it.

## Core Module:
Provides foundational classes and utilities which revolve around the UI.

## Data Module:
Defines the implementation of the Repository (since the interface belongs to the Domain layer).

## Domain Module:
Defines the data model and use cases used by the AlbumsViewModel.
The repository is defined as interface in the domain layer and not in the data one (unlike
nowinandroid) as I consider it that's contribute to the domain business logic definition

## Network Module:
Defines the network API for fetching albums.
Provides an implementation of the AlbumsApi interface.

# Third-party libraries choice
#### Hilt:
To facilitate testing of components, **AlbumsLBC** uses dependency injection with
[Hilt](https://developer.android.com/training/dependency-injection/hilt-android).

#### Glide:
To load images efficiently I preferred using [Glide](https://bumptech.github.io/glide/int/compose.html)
over an other library for two reasons : 
1. Already used it and master it
2. Described as focused on smooth scrolling in the [Android official documentation](https://developer.android.com/develop/ui/compose/graphics/images/loading)

#### MockK: 
[MockK](https://mockk.io/) is easy to use and implement and facilitate to mocking data and use some Kotlin DSL features

#### Retrofit & OkHttp: 
The essentials for creating an API interface and making http calls easily

#### Room: 
To saving data in a local database, **AlbumsLBC** use [Room](https://developer.android.com/training/data-storage/room).
The choice was made on Room for performance and scalability reasons. 
I could use a simple DataStore to store a simple json file, but if the project grows, the performance 
could be optimized with a database (make specific requests for example) better especially if the structure 
becomes complex.

# Testing

All the logical parts of the **AlbumsLBC** are tested : 
- [AlbumsRepositoryTest.kt](core%2Fdata%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkdroid_consulting%2Fdata%2Frepository%2FAlbumsRepositoryTest.kt): 
Unit Test the right way to provide the cache or fetched the from the API.
- [GetAlbumsUseCaseTest.kt](core%2Fdomain%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkdroid_consulting%2Fdomain%2Fusecase%2FGetAlbumsUseCaseTest.kt): 
For this example it only call the repository without other logical rules.
- [AlbumsViewModelTest.kt](feature%2Falbum%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkdroid_consulting%2Falbums%2Fscreen%2FAlbumsViewModelTest.kt): 
Test the UI behaviour of each state.
- [AlbumsEntityKtTest.kt](core%2Fdata%2Fsrc%2Ftest%2Fjava%2Fcom%2Fkdroid_consulting%2Fmodel%2FAlbumsEntityKtTest.kt): 
For the mapping of models from (and to) entity vs data vs domain

# UI

The Screen and the Components are built entirely using [Jetpack Compose](https://developer.android.com/jetpack/compose).
The Screen is composed of several Components as following : 
- [AlbumComponent.kt](feature%2Falbum%2Fsrc%2Fmain%2Fjava%2Fcom%2Fkdroid_consulting%2Falbums%2Fcomponent%2FAlbumComponent.kt): 
Describe an Album that's composed of multiple songs 
- [AlbumsCatalogComponent.kt](feature%2Falbum%2Fsrc%2Fmain%2Fjava%2Fcom%2Fkdroid_consulting%2Falbums%2Fcomponent%2FAlbumsCatalogComponent.kt):
List of Album
- [AlbumsErrorComponent.kt](feature%2Falbum%2Fsrc%2Fmain%2Fjava%2Fcom%2Fkdroid_consulting%2Falbums%2Fcomponent%2FAlbumsErrorComponent.kt):
Describe the error state
- [AlbumsLoadingComponent.kt](feature%2Falbum%2Fsrc%2Fmain%2Fjava%2Fcom%2Fkdroid_consulting%2Falbums%2Fcomponent%2FAlbumsLoadingComponent.kt):
Describe the loading state
- [SongComponent.kt](feature%2Falbum%2Fsrc%2Fmain%2Fjava%2Fcom%2Fkdroid_consulting%2Falbums%2Fcomponent%2FSongComponent.kt): 
Describe a song

All the Components contains a Preview to facilitate the understanding.

# License

This project **AlbumsLBC** is licensed under the Apache License 2.0.

Copyright 2024 Kheireddine OUELAA (for KDROID CONSULTING)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
