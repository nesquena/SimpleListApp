# Pre-work - SimpleListApp

SimpleListApp is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Pooja Venkatram

Time spent: 4 hours spent in total

## User Stories

The following **required** functionality is completed:

* [Y] User can **successfully add and remove items** from the todo list
* [Y] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [Y] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [Not Yet] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [Not Yet] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [Not Yet] Add support for completion due dates for todo items (and display within listview item)
* [Not Yet] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [Not Yet] Add support for selecting the priority of each todo item (and display in listview item)
* [Not Yet] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/JO2PVGI.gifv' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Understanding the impact of changing values directly in the list adapter versus changing the list items themselves was interesting. Also, in understanding how to open a new Activity and use the Value entered, I am not sure if the way I have implemented it is best because I just used a static global variable in the other class to store this value and read from the Edit class. The better way would be to store it as part of the intent returned to the Main Activity.

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
