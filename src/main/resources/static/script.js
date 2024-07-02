document.addEventListener("DOMContentLoaded", function () {
  const emailForm = document.getElementById("emailForm");

  emailForm.addEventListener("submit", async function (event) {
    event.preventDefault(); // Prevent the default form submission

    // Collect form data
    const formData = new FormData(emailForm);

    try {
      const response = await fetch("send_email.php", {
        method: "POST",
        body: formData,
      });

      if (response.ok) {
        // Email sent successfully
        console.log("Email sent!");
      } else {
        // Handle errors (e.g., server error, validation failure)
        console.error("Error sending email:", response.statusText);
      }
    } catch (error) {
      console.error("Error sending email:", error.message);
    }
  });
});
