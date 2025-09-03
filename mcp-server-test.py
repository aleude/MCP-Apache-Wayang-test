import sys, logging
from mcp.server.fastmcp import FastMCP

# Log KUN til stderr eller fil (ikke stdout)
logging.basicConfig(stream=sys.stderr, level=logging.INFO)

mcp = FastMCP("DemoMCP")

@mcp.tool()
def add(num1: float, num2: float) -> float:
    logging.info(f"add({num1}, {num2})")
    return num1 + num2

if __name__ == "__main__":
    # Viktigt: ingen host/port/path her. STDIO er standard.
    mcp.run()