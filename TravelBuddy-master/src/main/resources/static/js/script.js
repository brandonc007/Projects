document.getElementById('myForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    // Get form values
    var name = document.getElementById('name').value;
    var review = document.getElementsByName('review')[0].value;
    var rating = document.querySelector('input[name="rating"]:checked').value;
    
    // Store data in a variable
    var formData = {
        name: name,
        review: review,
        rating: rating
    };
    
    // Log form data
    console.log(formData);
    
    // Submit the form
    document.getElementById('myForm').submit();
});
