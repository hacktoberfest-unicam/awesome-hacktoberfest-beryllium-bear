#!/bin/bash

# Example 1: Basic Regular Expression
string="Hello, World!"
pattern="Hello"

if [[ $string =~ $pattern ]]; then
  echo "Example 1: '$pattern' found in '$string'"
else
  echo "Example 1: '$pattern' not found in '$string'"
fi

# Example 2: Character Classes
string="1234-5678-9012-3456"
pattern="[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}"

if [[ $string =~ $pattern ]]; then
  echo "Example 2: Credit card pattern found in '$string'"
else
  echo "Example 2: Credit card pattern not found in '$string'"
fi
