<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions">
<xsl:template match="/">
 <html>
  <body>
    <h2>Company</h2>
    <table border="1">
    <tr bgcolor="#9acd32">
      <th align="center">Name</th>
      <th align="center">Email</th>
      <th align="center">Mobile Phone</th>
      <th align="center">Address</th>
    </tr>
    <xsl:for-each select="company/employee">
    <tr>
      <td><xsl:value-of select="Name"/></td>
      <td><xsl:value-of select="Email"/></td>
      <td><xsl:value-of select="Phones/Phone[@Type = 'mobile']"/></td>
      <td><xsl:value-of select="Address/Region"/></td>
    </tr>
    </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>