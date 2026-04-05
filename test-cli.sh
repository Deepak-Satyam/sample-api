#!/bin/bash
# SpecShield CLI — full feature test script
# Run from: /Users/deepaksatyam/IntellijProject/claude/sample-api/
# Requires: npm install -g specshield

BASE="specs/v1.yaml"
TARGET="specs/v2.yaml"
DIVIDER="━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

echo ""
echo "$DIVIDER"
echo "  SpecShield CLI — Feature Test Suite"
echo "$DIVIDER"
echo ""

# ─── TEST 1: Basic compare ────────────────────────────────────────────────────
echo "TEST 1: Basic compare (human-readable output)"
echo "$DIVIDER"
specshield compare $BASE $TARGET
echo ""

# ─── TEST 2: JSON output ──────────────────────────────────────────────────────
echo "TEST 2: JSON output"
echo "$DIVIDER"
specshield compare $BASE $TARGET --json
echo ""

# ─── TEST 3: Save to file ────────────────────────────────────────────────────
echo "TEST 3: Save result to file (result.json)"
echo "$DIVIDER"
specshield compare $BASE $TARGET --output result.json
echo "  → File written: result.json"
echo ""

# ─── TEST 4: Fail on breaking ─────────────────────────────────────────────────
echo "TEST 4: --fail-on-breaking (expect exit code 1)"
echo "$DIVIDER"
specshield compare $BASE $TARGET --fail-on-breaking
EXIT=$?
echo "  → Exit code: $EXIT (expected: 1)"
echo ""

# ─── TEST 5: No breaking changes → exit 0 ────────────────────────────────────
echo "TEST 5: Compare identical specs (expect exit code 0)"
echo "$DIVIDER"
specshield compare $BASE $BASE --fail-on-breaking
EXIT=$?
echo "  → Exit code: $EXIT (expected: 0)"
echo ""

# ─── TEST 6: Ignore a specific change ────────────────────────────────────────
echo "TEST 6: --ignore a known breaking change"
echo "$DIVIDER"
specshield compare $BASE $TARGET \
  --ignore "DELETE /api/users/{id} removed" \
  --fail-on-breaking
EXIT=$?
echo "  → Exit code: $EXIT"
echo ""

# ─── TEST 7: Severity filter — info ──────────────────────────────────────────
echo "TEST 7: --severity info (show everything)"
echo "$DIVIDER"
specshield compare $BASE $TARGET --severity info
echo ""

# ─── TEST 8: Severity filter — warning ───────────────────────────────────────
echo "TEST 8: --severity warning (filter out info-level)"
echo "$DIVIDER"
specshield compare $BASE $TARGET --severity warning
echo ""

# ─── TEST 9: JSON + save to file ─────────────────────────────────────────────
echo "TEST 9: JSON output saved to file"
echo "$DIVIDER"
specshield compare $BASE $TARGET --json --output report.json
echo "  → File written: report.json"
cat report.json | python3 -m json.tool --no-ensure-ascii 2>/dev/null | head -20
echo ""

# ─── TEST 10: Custom config file ─────────────────────────────────────────────
echo "TEST 10: --config flag (uses .specshield.yml)"
echo "$DIVIDER"
specshield compare $BASE $TARGET --config .specshield.yml
echo ""

# ─── TEST 11: specshield login ───────────────────────────────────────────────
echo "TEST 11: specshield login"
echo "$DIVIDER"
echo "  → Run manually with your API key:"
echo "     specshield login --api-key ss_YOUR_KEY_HERE"
echo ""

# ─── TEST 12: Remote compare ─────────────────────────────────────────────────
echo "TEST 12: Remote compare (requires login first)"
echo "$DIVIDER"
echo "  → Run after login:"
echo "     specshield compare $BASE $TARGET --remote --fail-on-breaking"
echo ""

# ─── TEST 13: specshield logout ──────────────────────────────────────────────
echo "TEST 13: specshield logout"
echo "$DIVIDER"
echo "  → Run manually:"
echo "     specshield logout"
echo ""

echo "$DIVIDER"
echo "  All automated tests complete."
echo "  Tests 11–13 require a live SpecShield API key."
echo "$DIVIDER"
echo ""
