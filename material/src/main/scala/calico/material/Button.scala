/*
 * Copyright 2023 Arman Bilge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package calico.material

import calico.html.Prop
import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

opaque type Button[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]

opaque type FilledButton[F[_]] <: Button[F] = Button[F]
private object FilledButton:
  @inline def apply[F[_]]: FilledButton[F[_]] = Raw().asInstanceOf[FilledButton[F]]

  @JSImport("@material/web/button/filled-button.js")
  @js.native
  private class Raw extends js.Object

opaque type OutlinedButton[F[_]] <: Button[F] = Button[F]
private object OutlinedButton:
  @inline def apply[F[_]]: OutlinedButton[F[_]] = Raw().asInstanceOf[OutlinedButton[F]]

  @JSImport("@material/web/button/outlined-button.js")
  @js.native
  private class Raw extends js.Object

private trait MaterialButton[F[_]](using F: Async[F]):

  def mdFilledButton: MdTag[F, FilledButton[F]] = MdTag(FilledButton[F])

  def mdOutlinedButton: MdTag[F, OutlinedButton[F]] = MdTag(OutlinedButton[F])

  extension (button: Button[F]) def label: Prop[F, String, String] = Prop("label", identity)