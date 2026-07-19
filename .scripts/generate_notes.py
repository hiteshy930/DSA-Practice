#!/usr/bin/env python3
import subprocess
from pathlib import Path

def get_last_commit_files():
    out = subprocess.check_output(["git", "diff-tree", "--no-commit-id", "--name-only", "-r", "HEAD"]) 
    return [s.strip() for s in out.decode().splitlines() if s.strip()]

def ensure_notes_dir(path: Path):
    path.mkdir(parents=True, exist_ok=True)

def make_notes_path(file_path: str) -> Path:
    p = Path(file_path)
    notes_root = Path("NOTES")
    notes_file = notes_root / p.with_suffix("").as_posix()  # keep subdirs
    notes_file = notes_file.with_suffix('.md')
    return notes_file

def append_note(notes_path: Path, question: str, solution: str):
    ensure_notes_dir(notes_path.parent)
    row = f"| {question.replace('|', '/') } | {solution.replace('|', '/')} |\n"
    if notes_path.exists():
        with notes_path.open('a', encoding='utf-8') as f:
            f.write(row)
    else:
        with notes_path.open('w', encoding='utf-8') as f:
            f.write("| Question | Solution |\n")
            f.write("|---|---|\n")
            f.write(row)

def main():
    try:
        files = get_last_commit_files()
    except subprocess.CalledProcessError:
        print("Failed to get last commit files. Run this from a git repository.")
        return

    if not files:
        print("No files changed in last commit.")
        return

    relevant = [f for f in files if f.endswith('.java') or f.endswith('.py') or f.endswith('.js')]
    if not relevant:
        print("No code files found in last commit to add notes for.")
        return

    print("Adding short notes for the last commit. Please enter brief answers.")
    for f in relevant:
        print(f"\nFile: {f}")
        q = input("Question (one line) : ").strip()
        s = input("Solution (one line) : ").strip()
        notes_path = make_notes_path(f)
        append_note(notes_path, q, s)
        print(f"Wrote notes to {notes_path}")

if __name__ == '__main__':
    main()
