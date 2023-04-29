# Generics and Collections
<div align="center">
<table>
<th>Functional Interface</th>
<th>Return Type</th>
<th>Method Name</th>
<th>Parameters</th>
<tr>
<td>Supplier &lt T&gt </td>
<td>T</td>
<td>get()</td>
<td>0</td>
</tr>

<tr>
<td>Consumer &lt T&gt </td>
<td>void</td>
<td>accept(T)</td>
<td>(T)</td>
</tr>

<tr>
<td>BiConsumer &lt T,U&gt </td>
<td>void</td>
<td>accept(T,U)</td>
<td>(T,U)</td>
</tr>
<tr>
<td>Predicate &lt T&gt </td>
<td>boolean</td>
<td>test(T)</td>
<td>(T)</td>
</tr>

<tr>
<td>BiPredicate &lt T&gt </td>
<td>boolean</td>
<td>test(T,U)</td>
<td>(T,U)</td>
</tr>

<tr>
<td>Function &lt T,R&gt </td>
<td>R</td>
<td>apply(T)</td>
<td>(T)</td>
</tr>
<tr>
<td>BiFunction &lt T,U,R&gt </td>
<td>R</td>
<td>apply(T,U)</td>
<td>(T,U)</td>
</tr>
<tr>
<td>UnaryOperator &lt T&gt </td>
<td>T</td>
<td>apply(T)</td>
<td>(T)</td>
</tr>


</table>
</div>