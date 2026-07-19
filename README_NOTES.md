How to enable automatic short notes on commit

1. Enable the repository to use the provided hooks directory:

```bash
git config core.hooksPath .githooks
```

2. Make the hook and script executable:

```bash
chmod +x .githooks/post-commit .scripts/generate_notes.py
```

3. Workflow:
- After you commit code, the hook will run and prompt for a short `Question` and `Solution` for each changed code file in the commit.
- The notes are written as markdown files under the `NOTES/` directory preserving subpaths. Example: `Array/RotateArrayByDPositions.java` -> `NOTES/Array/RotateArrayByDPositions.md`.

4. If you prefer not to enable hooks repository-wide, run the script manually after commit:

```bash
python3 .scripts/generate_notes.py
```
