# Changelog

## 1.1.5 - Nov 15, 2014

-  bug-11: [Yair Liberzon] (yair.liberzon@zoomd.com) and [Sivan Ravid](sivan.ravid@zoomd.com) noted that the log messages still show up when the Alchemy service returns the non-standard JSON boolean.

 The only differences between 1.1.4 and this version is that:

    - the log levels for those messages changed from WARN to DEBUG
    - java.source.version changed from 1.6 to 1.7 (might as well be current)
    - java.target.version changed from 1.6 to 1.7 (might as well be current)

## 1.1.4 - Oct 15, 2014

-  bug-11: Thanks to [Yair Liberzon] (yair.liberzon@zoomd.com) and [Sivan Ravid](sivan.ravid@zoomd.com) for reporting this bug
  - AlchemyAPI code expects standard JSON boolean value true/false, the AlchemyAPI service returns yes/no

## 1.1.3 - Oct 09, 2014

-  bug-10: Thanks to [bellorap](https://github.com/bellorap) for discovering this bug.
  - Client#post(String,String,Params) now throws IOException instead of swallowing it.

## 1.1.2 - May 30, 2014

-  Ranked Categories - not supported by AlchemyApi? ([#8](https://github.com/likethecolor/Alchemy-API/issues/8))

## 1.1.1 - Oct 02, 2013

- Removed unnecessary IOException from Client (thanks to [Amir Raminfar](https://github.com/amir20))
- Unchecked assignment when doing client.call  ([#6](https://github.com/likethecolor/Alchemy-API/issues/6)) ([#7](https://github.com/likethecolor/Alchemy-API/issues/7))  (thanks to [Amir Raminfar](https://github.com/amir20))

## 1.1.0 - Oct 01, 2013

- setAPIKey should be private ([#5](https://github.com/likethecolor/Alchemy-API/issues/5))  (thanks to [Amir Raminfar](https://github.com/amir20))

## 1.0.1 - Jan 07, 2013
- OutputStatusValidator logs the json string returned from AlchemyAPI service ([#2](https://github.com/likethecolor/Alchemy-API/issues/2))
- AbstractParser sets status instead of status info ([#3](https://github.com/likethecolor/Alchemy-API/issues/3))
