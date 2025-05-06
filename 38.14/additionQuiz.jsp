<%@ page import="java.util.Random" %>
<%
    int numQuestions = 10;
    int[] num1 = new int[numQuestions];
    int[] num2 = new int[numQuestions];
    boolean showResults = request.getParameter("submit") != null;

    if (!showResults) {
%>
    <form method="post">
        <h3>Addition Quiz</h3>
        <%
            Random rand = new Random();
            for (int i = 0; i < numQuestions; i++) {
                num1[i] = rand.nextInt(50) + 1;
                num2[i] = rand.nextInt(50) + 1;
        %>
            <%= num1[i] %> + <%= num2[i] %> =
            <input type="text" name="answer<%=i%>">
            <input type="hidden" name="num1<%=i%>" value="<%=num1[i]%>">
            <input type="hidden" name="num2<%=i%>" value="<%=num2[i]%>">
            <br>
        <% } %>
        <br>
        <input type="submit" name="submit" value="Submit">
    </form>
<%
    } else {
        int correctCount = 0;
%>
    <h3>Addition Quiz Answer</h3>
    <%
        for (int i = 0; i < numQuestions; i++) {
            int n1 = Integer.parseInt(request.getParameter("num1" + i));
            int n2 = Integer.parseInt(request.getParameter("num2" + i));
            int correctAnswer = n1 + n2;
            String userAnswerStr = request.getParameter("answer" + i);
            int userAnswer = 0;

            try {
                userAnswer = Integer.parseInt(userAnswerStr);
            } catch (Exception e) {
                userAnswer = -9999; // Invalid input
            }

            boolean isCorrect = (userAnswer == correctAnswer);
            if (isCorrect) correctCount++;
    %>
        <%= n1 %> + <%= n2 %> = <%= userAnswer %>
        <%= isCorrect ? "Correct" : "Wrong" %><br>
    <% } %>
    <br>
    <strong>Total correct count is: <%= correctCount %></strong>
<% } %>
