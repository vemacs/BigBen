BigBen for Bukkit
=================

An in-progress clone for BigBen, but for Bukkit. It's written completely from scratch.

What works perfectly
--------------------

-Bonging every hour (defined explicitly as 3600000 milliseconds in the code) (has been tested)
-Correct number of bongs for UTC time

What works
----------

-Answering to player responses with random hardcoded values

What's not implemented
----------------------

-Response overrides
-Customizable responses
-Customizable prefix
-Permissions

Features
--------

-Extremely low CPU usage with the same bonging method that the original BigBen uses
-Accurate bonging
-Responds to player questions with the same format as the original BigBen (BigBen: *??)
-THREADING OMG

Todo (performancewise)
----------------------
-investigate the code to find out possible memory leaks

Info
-------

This has been compiled with JRE6 and Bukkit 1.3.2 R3.0, it has been tested with Spigot 1.4.5 R0.3.
Thanks to TheCrittaC for the original concept and providing me the algorithm for bonging without constantly calling an if-loop.
