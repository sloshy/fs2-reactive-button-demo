# FS2 Reactive Button Example
This is the (very simple and tiny) code used to reactively render a button in my presentation: ["Streams - Your New Favorite Primitive"](https://slides.rpeters.dev/fs2-streams/).
No extra libraries were used except for FS2, which of course depends on the wonderful Cats Effect library, and ScalaJS-DOM.

**NOTE:** This style of rendering changes to the DOM is pretty inefficient at scale. Consider using a JavaScript framework such as React or Vue or something which is able to handle large changes efficiently. Both can work with this style of state management as well.