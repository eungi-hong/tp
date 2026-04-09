---
  layout: default.md
  title: "User Guide"
  pageNav: 4
---

# Hairy Pawter User Guide

Hairy Pawter is a desktop app created to help pet groomers reach their clients.
It works independently of other apps, and can help groomers handle both walk-in clients and clients who arrive for appointments.

Use Hairy Pawter to quickly jot down contact details of clients and their pets when they arrive,
so that after grooming a pet, you can quickly find the details of the owner and contact them.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Installation

1. [Install](https://se-education.org/guides/tutorials/javaInstallation.html) `Java 17` or higher to your computer.
    * `Java 17` is the programming language that Hairy Pawter runs on.

2. Download `hairypawter.jar` from the latest release [here](https://github.com/AY2526S2-CS2103T-F14-2/tp/releases).
    * You should be able to see it inside your Downloads folder.

3. Move `hairypawter.jar` to the folder you want to use as the _home folder_ for this app.
    * You can create a folder called Hairypawter and drag `hairypawter.jar` inside it.

4. Double-click on `hairypawter.jar` to run it.

<box type="info" seamless>

**If double-clicking does not run the app:**<br>

5. Open a command terminal

    * Windows users can use the search bar on the bottom of the screen to search for `Command Prompt` and run it.

    * Mac users can use spotlight search `Cmd` + `SPACE` to search for `Terminal` and run it.

    * Linux users can try `Ctrl` + `Alt` + `T`.

6. In the command terminal, enter the command `cd PATH` where PATH is the location of the _home folder_. (e.g. `cd C:\Users\jeff\Desktop\HairyPawter\`)
    * You can right click on the _home folder_ and select the option most similar to `Copy as path`, then paste it after `cd `.

7. In the command terminal, enter the command `java -jar hairypawter.jar` to start the app.<br>
    * Once the app starts, you can ignore the rest of the activity on the command terminal. Closing it will close the app.
</box>

<img src="images/Ui.png" class="app-screenshot" alt="Ui">

--------------------------------------------------------------------------------------------------------------------

## Commands

In the app, type a command in the command box (at the bottom) and press Enter to execute it. (e.g. typing **`help`** and pressing Enter will open the help window)<br>

<box type="info" seamless>

**Reading the command guide:**<br>

* Words in `UPPER_CASE` should be replaced with real values.<br>
  e.g. `client n/NAME` should be used as `client n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `[t/TAG]` can be ignored.

* Items with `…`​ can be used multiple times.<br>
  e.g. `[t/TAG]…​` can be used as `t/regular t/text, don't call`.

* Items can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</box>

### Viewing help : `help`

You would use the `help` command when you don't remember the command to perform a specific action.

This command shows a message explaining how to access the user guide (this document), to view the list of commands and how to use them.

<img src="images/helpMessage.png" class="app-screenshot" alt="help message">

Format: `help`

<br><br>

### Adding a client: `addClient`

Registers a new client. The new client will be shown on the list.

<box type="tip" seamless>

**Important:** Clients cannot have the same phone number.
</box>

Format: `addClient p/PHONE_NUMBER [n/NAME] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

Examples:
* `addClient n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `addClient n/Betsy Crowe t/friend e/betsycrowe@example.com a/Crown street p/1234567`

<box type="info" seamless>

**Using `[t/TAG]...` to your advantage:**<br>

* You can use many `[t/TAG]`s to note down additional information about a client.

* These can be their preferences, or the date they visited for easy searching.
</box>

<br><br>

### Adding a pet: `addPet`

Registers a new pet of a client. The name of the pet and the **phone number of the client** are needed.

Format: `addPet n/NAME p/PHONE_NUMBER​ [s/SPECIES] [b/BREED] [nt/NOTES] [ph/PHOTO]`

Examples:
* `addPet n/Snowy p/0000 s/Dog b/Wire Fox Terrier (White)`
* `addPet n/Meowy p/123456`

**Using `[nt/NOTES]...` to your advantage:**<br>

* Notes exists to record down important information about the pet. This can be identifying information
like leash colour, or allergies and quirks of the pet. Use this flexibly!

</box>

<br><br>

### Listing all clients and pets : `list`

Shows all clients and pets.

Format: `list`

<br><br>

### Editing a client : `editClient`

Edits an existing client.

* Edits the client at the specified `POSITION`. The `POSITION` refers to the number shown next to the client.​
* Specified values will override old values.
* Editing tags will clear previous tags.
* You can remove a client’s tags by typing `t/` without
    specifying any tags after it.

Format: `editClient POSITION [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`
* You need to edit at least one of the optional values.

Examples:
*  `editClient 1 p/91234567 e/johndoe@example.com` Edits the details of the client in `POSITION` 1.
*  `editClient 2 n/Betsy Crower t/` Changes the name of the client in `POSITION` 2 to `Betsy Crower` and clears their tags.

<br><br>

### Editing a pet : `editPet`

Edits an existing pet.

* Edits the pet at the specified `POSITION`. The `POSITION` refers to the number shown next to the pet.​
* Specified values will override old values.

Format: `editPet POSITION [n/NAME] [s/SPECIES] [b/BREED]​ [nt/NOTES] [ph/PHOTO]`
* You need to edit at least one of the optional values.

Examples:
*  `editPet 1 s/cat` Edits the species of the pet in `POSITION` 1.
*  `editPet 2 n/Gunner` Changes the name of the pet in `POSITION` 2 to `Gunner`.

<br><br>

### Locating clients and pets by keywords: `find`

Finds pets and clients who match **all** of the given keywords.

* The match is partial and case-insensitive. e.g `Roy` will match `Leroy`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`

Format: `find KEYWORD...`

Examples:
* `find Yu` returns clients named `yusuf` and `Yuri` with their pets.
* `find Yu cat` returns clients with their pets, if both `yu` and `cat` appear in either their details or any of their pets' details.


<img src="images/findYuCatResult.png" class="app-screenshot" alt="result for find Yu Cat">

<br><br>

### Deleting a client : `deleteClient`

Deletes the specified client.

* Deletes the client at the specified `POSITION`.
* The `POSITION` refers to the `POSITION` number shown in the displayed client list.​

Format: `deleteClient POSITION`

Examples:
* `list` followed by `delete 2` deletes the client with `POSITION` 2 in the displayed list.
* `find Betsy` followed by `delete 1` deletes the 1st client in the results of the `find` command.

<br><br>

### Deleting a pet : `deletePet`

Deletes a pet.

* Deletes the pet at the specified `POSITION`.
* The `POSITION` refers to the `POSITION` number shown next to the pet.​
Format: `deletePet POSITION`

Examples:
* `deletePet 1`

<br><br>

### Clearing all records : `clear`

Clears all records from memory. Be careful with this command.

Format: `clear`

<br><br>

### Exiting the app : `exit`

Exits the app.

Format: `exit`

<br><br>

### Saving the data

Data is saved automatically. There is no need to save manually.

<br><br>

### Editing the data file

Data is saved automatically as a JSON file `[hairypawter.jar file location]/data/addressbook.json`.
It is possible, but not recommended, to update data directly by editing that data file.

<box type="info" seamless>

**Caution:**
If your changes to the data file makes its format invalid, the entire file will be discarded the next time the app is opened.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the app to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

<br><br>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: Is it safe to click the close button instead of typing `exit`?<br>
**A**: Yes.


**Q**: What should I do if I have clients who do not have a phone?<br>
**A**: You can put their preferred contact method under [p/PHONE_NUMBER].


**Q**: How do I reorder my clients?<br>
**A**: Unfortunately, we do not have a reorder function.
One way to do this is to close the app and manually reorder the clients in the data file.


**Q**: How do I transfer my data to another computer?<br>
**A**: Install the app on the other computer and replace the data file on the other computer.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action     | Format, Examples
-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------
**AddClient** | `addClient p/PHONE_NUMBER [n/NAME] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` <br> e.g., `addClient n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend`
**AddPet** | `addPet n/NAME p/PHONE_NUMBER​ [s/SPECIES] [b/BREED] [nt/NOTES] [ph/PHOTO]` <br> e.g., `addPet n/Meowy p/22224444`
**Clear**  | `clear`
**DeleteClient** | `deleteClient POSITION`<br> e.g., `deleteClient 3`
**DeletePet** | `deletePet POSITION`<br> e.g., `deletePet 1`
**EditClient**   | `editClient POSITION [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`editClient 2 n/James Lee e/jameslee@example.com`
**EditPet**   | `editPet POSITION [n/NAME] [s/SPECIES] [b/BREED] [nt/NOTES] [ph/PHOTO]`<br> e.g.,`editPet 2 n/Pongo`
**Exit**   | `exit`
**Find**   | `find KEYWORD...`<br> e.g., `find James dog`
**Help**   | `help`
**List**   | `list`


## Short-form commands
For advanced users, Hair Pawter supports short-forms for some commands.
* `AddClient` can be shortened to `ac`
* `AddPet` can be shortened to `ap`
* `EditClient` can be shortened to `ec`
* `EditPet` can be shortened to `ep`
* `DeleteClient` can be shortened to `dc`
* `DeletePet` can be shortened to `dp`
