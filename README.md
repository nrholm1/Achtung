# ACHTUNG

The classic game Achtung Die Kurwe/Curve Fever written in JavaFx 
with standard Java networking libraries for connecting and playing multiplayer via LAN.

Overview of the project structure:
```bash
├── Game
│   ├── PlayerObjects
│   │   ├── Coord
│   │   ├── Kurwe
│   │   └── Vec2D
│   ├── GameConstants
│   └── GameLogic
├── Networking
│   ├── TestDriver
│   ├── Client
│   │   ├── ServerSocket (?)
│   │   └── Client
│   ├── Server
│   │   ├── ClientHandler
│   │   ├── CommonRuntime
│   │   ├── SocketListener
│   │   └── StateRenderer
│   └── Utils
│       ├── Payload
│       └── PayloadBuilder
└── GUI
    ├── Main
    ├── MenuController
    ├── GameWindowController
    ├── Render
    └── RenderTestDriver
```