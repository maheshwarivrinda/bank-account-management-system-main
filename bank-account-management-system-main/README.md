# bank-account-management-system
A Java application for managing bank accounts, transactions, and account operations. 
Planeringsmall

Projektidé
A system for managing a bank's customers account. The program will allow the users to create, remove, deposit money into and withdraw money from different types of bank account.   


Superklass
Namn: Bank Account
Gemensamma fält: customerName, balance
Gemensamma metoder: deposit(), withdraw(), get balance(), 

Subklasser (minst tre)
Namn — private account
Namn — Saving account
Namn — Bussiness account

Interface
Namn:
Metod(er):
Implementeras av (minst två subklasser):
Meny
Lista minst fyra åtgärder kopplade till samlingen (t.ex. lägga till, ta bort, söka, samt en egen åtgärd som passar er domän).

Felscenarion
Minst två konkreta situationer i just ert program som kan gå fel och som ni behöver hantera (inte generella exempel).

Motivering (fylls i senare i veckan)
När ni kommit igång och gjort några ändringar: skriv kort varför strukturen ser ut som den gör, och om ni övervägde ett annat sätt att lösa det på. Detta behöver inte fyllas i redan i första commiten.

Exempel (ifyllt) — Biblioteksystem
Projektidé: Ett system för att hantera ett biblioteks samling av utlåningsbara medier och vilka som är utlånade.

Superklass

Namn: Media
Gemensamma fält: title, id, isBorrowed (true/false)
Gemensamma metoder: showInfo(), borrow()
Subklasser

Book — overridar showInfo() för att även visa författare
Magazine — overridar borrow() eftersom tidskrifter bara får lånas i en vecka
Movie — overridar showInfo() för att visa åldersgräns
Interface

Namn: Reservable
Metod: reserve()
Implementeras av: Book, Movie
Meny

Lägga till medium
Ta bort medium
Söka på titel
Låna ut/lämna tillbaka
Reservera
Felscenarion

Försök att låna ut ett medium som redan är utlånat
Försök att skapa ett medium med tomt titel-fält
