# Privacy

- No `INTERNET` permission: the app cannot talk to the network.
- No analytics, crash reporting, or telemetry of any kind.
- No contacts permission; backups are disabled (`allowBackup=false`).
- Typed text stays on the device; learned words live in app-private storage.
- `tools/privacy-check.sh` enforces the above and should run in CI.
