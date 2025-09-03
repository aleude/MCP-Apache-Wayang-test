from fastmcp import FastMCP

mcp = FastMCP("My MCP Server")

@mcp.tool
def greet(name: str) -> str:
        return f"Hello, {name}!"

@mcp.tool
def add_numbers(num1, num2):
      return num1 + num2

if __name__ == "__main__":
   #mcp.run(transport="sse", host="127.0.0.1", port=8000)
   #mcp.run()
   mcp.run(transport="streamable-http", host="127.0.0.1", port=8000)