# Same-Origin Policy in Action

# Cross-Site Scripting

"You are injecting a script (or markup) in another page or site."

We have a tipical notion of 3 types of XSS:

+ Persistent
+ Reflected
+ DOM-based

Actually we have 2 orthogonal classification:

+ where the code resides
+ is it persistent or reflected

First occurence of XSS: 1999 by Microsoft, in custom 404 pages 

DOM-based is a strange definition.
The actual name would be **Client-Side Cross-Site Scripting**.

## Impact 

Javascript allows the attacker to pretend to be
* user towards the server
* server towards the user

*Obvious target*: session hijacking (stealing cookies)
or session fixation (setting cookies)
(somehow mitigated by HTTPOnly cookies, JS can't access them)

**PAPER**: autocompletion of password for browser password managers.

Real-World XSS: Ubuntu forums in 2013 in vBullettin forum

## Dimensions

Client -> Server
and
Reflected -> Persistent


Server + Reflected is the standard echo
Client + Stored is Local storage

## Server-Side Cross-Site Scripting

### Reflected Server-Side Cross-Site Scripting

Attacker probes server for vulnerabilities, by injecting markup and then injecting JS
He then lures the victim on the vulnerable site.

### Persistent Server-Side Cross-Site Scripting

You usually leverage a database on the server to store your payload which will be
displayed to the user.

Interesting: OCR as an injection vector.

(Search for Samy Kamkar on MySpace attack)

### Countermeasures

Input validation is bad.

Output validation is better, but you need to be careful.

WARNING: JavaScript engine decodes HTML entities

## Client-Side Cross-Site Scripting

You have a white-box approach now, you can search JS code for vulnerabilities.

Code is *never* sent to the server.

### Sinks for Client-Side XSS

* document.write, document.writeln
    * Can write new script tags
* eval, setTimeout, setInterval
    * Directly executes JS code
* innerHTML, outerHTML
    * does not execute JS directly, but event handlers work

**PAPER** Detecting Reflected Client-Side Cross-Site Scripting [CCS13]

It leverages on byte-level *taint tracking* in Chromium

An injection exploit is made of:
* Break-out sequence
* Exploit
* Break-in sequence

Break-out is performed on the AST.

**Interlude**: HSTS

Your browser always redirects you to HTTPS origin instead of HTTP.

    Strict-Transport-Security: max-age=1232

**PAPER**: Don't trust the locals (submitted to NDSS19)


# CSRF (*Sea Surf*)

Also called Session Riding

## Cross-Site Script Include (XSSI)

**PAPER**: Identifying potential XSSI [USENIX15]
**PAPER**: XSSI in the Wild [USENIX15]
