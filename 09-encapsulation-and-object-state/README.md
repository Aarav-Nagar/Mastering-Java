# Day 09: Encapsulation and Object State

This project is a small console-based thermostat simulator built to practice **encapsulation**, **object state**, and clean object interfaces.

You interactively enter an initial temperature and a target temperature (in either Celsius or Fahrenheit). The program then moves the current temperature toward the target in small steps, printing each tick.

## What it does

- Models temperature in a dedicated Temperature class
- Keeps fields private and exposes behavior through getters/setters
- Demonstrates constructor chaining and a useful 	oString()
- Uses a Thermostat class to manage current vs target state

## Compile and run (PowerShell)

From this folder:

`powershell
javac -d out (Get-ChildItem src -Filter *.java | ForEach-Object { .FullName })
java -cp out ThermostatApp
`

## Design notes

- Temperature owns the internal representation (Celsius) and provides conversions via methods, so callers do not need to duplicate formulas.
- Thermostat exposes state through methods rather than letting callers freely mutate both objects. For safety, getCurrent() / getTarget() return copies, not the internal references.
- The simulation step logic clamps overshoot, which keeps behavior stable for any positive step size.
