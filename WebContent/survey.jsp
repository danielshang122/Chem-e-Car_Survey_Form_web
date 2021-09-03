<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style><%@include file="survey.css"%></style>
<div class="container">
  <header class="header">
    <h1 id="title" class="text-center">McGill Chem-E Car Survey Form</h1>
    <p id="description" class="description text-center">
      Welcome to McGill Chem-E Car deisgn team
    </p>
  </header>
  <form id="survey-form">
    <div class="form-group">
      <label id="name-label" for="name">Name</label>
      <input type="text" name="name" id="name" class="form-control" placeholder="Enter your name" required />
    </div>
    <div class="form-group">
      <label id="id-label" for="id">McGill ID</label>
      <input type="text" name="id" id="id" class="form-control" placeholder="Enter your McGill ID" required />
    </div>
    <div class="form-group">
      <label id="email-label" for="email">Email</label>
      <input type="email" name="email" id="email" class="form-control" placeholder="Enter your McGill email" required />
    </div>
    <div class="form-group">
      <label id="years-label" for="years">Years<span class="clue"></span></label>
      <select id="dropdown" name="years" class="form-control" required>
        <option disabled selected value>(U0,U1,U2,U3,>U3)</option>
        <option value="U0">U0</option>
        <option value="U1">U1</option>
        <option value="U2">U2</option>
        <option value="U3">U3</option>
        <option value=">U3">>U3</option>
      </select>
    </div>
    <div class="form-group">
      <p>What is your major?</p>
      <select id="dropdown" name="major" class="form-control" required>
        <option disabled selected value>Select your major</option>
        <option value="Mechanical ">Mechanical Engineering</option>
        <option value="Electrical ">Electrical Engineering</option>
        <option value="Chemical ">Chemical Engineering</option>
        <option value="Software ">Software Engineering</option>
        <option value="Civil Engineering">Civil Engineering</option>
      </select>
    </div>

    <div class="form-group">
      <p>Would you recommend McGill Chem-E Car design team to a friend?</p>
      <label>
        <input name="recommendation" value="definitely" type="radio" class="input-radio" checked />Definitely</label>
      <label>
        <input name="recommendation" value="maybe" type="radio" class="input-radio" />Maybe</label>

      <label><input name="recommendation" value="not-sure" type="radio" class="input-radio" />Not sure</label>
    </div>

    <div class="form-group">
      <p>
        What is your favorite subteam of Chem-E Car deisgn team?
      </p>
      <select id="team" name="team" class="form-control" required>
        <option disabled selected value>Select an option</option>
        <option value="Power Source Sub-team">Power Source Sub-team</option>
        <option value="Mechanical Sub-team">Mechanical Sub-team</option>
        <option value="Electrical Sub-team">Electrical Sub-team</option>
        <option value="Management Sub-team">Management Sub-team</option>
      </select>
    </div>

    <div class="form-group">
      <p>
        What would you expect to get from the design team?
        <span class="clue">(Check all that apply)</span>
      </p>

      <label><input name="expect" value="Communication Skill" type="checkbox" class="input-checkbox" />Communication Skill</label>
      <label>
        <input name="expect" value="Leadership" type="checkbox" class="input-checkbox" />Leadership</label>
      <label><input name="expect" value="Technical Skill" type="checkbox" class="input-checkbox" />Technical Skill</label>
      <label><input name="expect" value="Self-learning" type="checkbox" class="input-checkbox" />Self-learning</label>
      <label><input name="expect" value="Team Work" type="checkbox" class="input-checkbox" />Team Work</label>
      <label><input name="expect" value="Problem Solving" type="checkbox" class="input-checkbox" />Problem Solving</label>
      <label><input name="expect" value="Critical Thinking" type="checkbox" class="input-checkbox" />Critical Thinking</label>

      <div class="form-group">
        <p>Any comments or suggestions?</p>
        <textarea id="comments" class="input-textarea" name="comment" placeholder="Enter your comment here..."></textarea>
      </div>

      <div class="form-group">
        <button type="submit" id="submit" class="submit-button">
          Submit
        </button>
      </div>
  </form>
</div>
</html>